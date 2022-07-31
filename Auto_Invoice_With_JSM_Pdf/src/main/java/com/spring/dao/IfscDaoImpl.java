package com.spring.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.dto.IfscDto;
import com.spring.model.Bank;
import com.spring.model.Ifsc;

@Repository
public class IfscDaoImpl implements IfscDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Ifsc> getIfsc() {
		Session session = sessionFactory.getCurrentSession();
	      CriteriaBuilder cb = session.getCriteriaBuilder();
	      CriteriaQuery<Ifsc> cq = cb.createQuery(Ifsc.class);
	      Root<Ifsc> root = cq.from(Ifsc.class);
	      cq.select(root);
	      Query<Ifsc> query = session.createQuery(cq);
	      return query.getResultList();
	
	}

	@Override
	public List<IfscDto> getIfscDto() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IfscDto entityToDto(Ifsc ifsc) {
		IfscDto ifc=new IfscDto();
		ifc.setIfscCode(ifsc.getIfscCode());
		
		return ifc;
	}

}
