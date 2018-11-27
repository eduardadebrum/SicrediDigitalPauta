package com.sicredidigitalpautas.eduardabrum.repository;

import com.sicredidigitalpautas.eduardabrum.domain.VotacaoResulDomain;
import com.sicredidigitalpautas.eduardabrum.entity.Votacao;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * Interface para customizar as consultas na base
 */
@Service
public class VotacaoRepositoryImpl implements VotacaoRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public boolean existsVotoAssociado(String cpfAssociado, Integer idPauta) {

        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);

        Root<Votacao> root = criteriaQuery.from(Votacao.class);
        List<Predicate> predicates = new ArrayList<>();

        criteriaQuery.select(criteriaBuilder.count(root));
        predicates.add(criteriaBuilder.equal(root.get("cpf"), cpfAssociado));
        predicates.add(criteriaBuilder.equal(root.get("idPauta"), idPauta));

        criteriaQuery.where(predicates.toArray(new Predicate[]{}));
        return em.createQuery(criteriaQuery).getSingleResult() == 1L;
    }

    @Override
    public List findAllResultadoVotacao() {
        List<VotacaoResulDomain> votacaoResulDomains = new ArrayList<>();

        List<Object[]> resultList = em.createNativeQuery(
                "SELECT pauta.tema, SUM(CASE WHEN  voto.SIMORNAOENUM = 1   THEN 1 ELSE 0 END), "
                        + "SUM(CASE WHEN  voto.SIMORNAOENUM = 0   THEN 1 ELSE 0 END)"
                        + "FROM VOTACAO voto "
                        + "INNER JOIN PAUTA pauta on  voto.ID_PAUTA = pauta.ID_PAUTA "
                        + "GROUP BY voto.ID_PAUTA, voto.SIMORNAOENUM").getResultList();

        if (CollectionUtils.isEmpty(resultList)) {
            return new ArrayList();
        }

        resultList.forEach(votacao ->
                votacaoResulDomains.add(
                        new VotacaoResulDomain((String) votacao[0], (BigInteger) votacao[1], (BigInteger) votacao[2]))
        );

        return votacaoResulDomains;
    }
}
