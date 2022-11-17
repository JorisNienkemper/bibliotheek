/*
 *
 *  ---------------------------------------------------------------------------------------------------------
 *              Titel: MemberDaoServiceTests.java
 *             Auteur: ebben00
 *    Creatietijdstip: 17/11/2022 13:08
 *          Copyright: (c) 2022 Belastingdienst / Centrum voor Applicatieontwikkeling en Onderhoud,
 *                     All Rights Reserved.
 *  ---------------------------------------------------------------------------------------------------------
 *                                              |   Unpublished work. This computer program includes
 *     De Belastingdienst                       |   Confidential, Properietary Information and is a
 *     Postbus 9050                             |   trade Secret of the Belastingdienst. No part of
 *     7300 GM  Apeldoorn                       |   this file may be reproduced or transmitted in any
 *     The Netherlands                          |   form or by any means, electronic or mechanical,
 *     http://belastingdienst.nl/               |   for the purpose, without the express written
 *                                              |   permission of the copyright holder.
 *  ---------------------------------------------------------------------------------------------------------
 *
 */
package nl.bld.bibliotheek.app.daos;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import nl.bld.bibliotheek.app.domain.Book;
import nl.bld.bibliotheek.app.domain.Member;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

/**
 * TODO: ebben00: beschrijf deze klasse !
 *
 * @author ebben00
 */

public class MemberDaoService implements MemberDaoServiceContract {
	//TODO verwijderen nadat geimplementeerd
	String persistenceUnitName = "bibliotheek-pu";
	EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName);
	EntityManager em = emf.createEntityManager();
	EntityTransaction tx = em.getTransaction();
	
	@Override
	public void save(Member member) {
		try {
			tx.begin();
			em.persist(member);
			tx.commit();
		} catch (Exception e) {
			System.out.println("Er is iets fout gegaan tijdens het opslaan van de Member");
			
			tx.rollback();
		}
	}
	
	@Override
	public void update(Member member) {
		try {
			tx.begin();
			em.merge(member);
			tx.commit();
		} catch (Exception e) {
			System.out.println("Er is iets fout gegaan tijdens het bewerken van de Member");
			tx.rollback();
		}
	}
	
	@Override
	public void remove(Member member) {
		try {
			tx.begin();
			em.remove(member);
			tx.commit();
		} catch (Exception e) {
			System.out.println("Er is iets fout gegaan tijdens het verwijderen van de Member");
			tx.rollback();
		}
	}
	
	@Override
	public Member getMemberById(Long id) {
		Member member = null;
		
		try {
			member = em.find(Member.class, id);
		} catch (Exception e) {
			System.out.println("Er is iets fout gegaan tijdens het ophalen van de Member met id=" + id);
		}
		
		return member;
	}
	
	//Hoeft geen list te zijn aangezien er een unique constraint zit op username
	@Override
	public List<Member> getMemberByUserName(String userName) {
		String queryString = "SELECT m FROM Member m WHERE userName = '" + userName + "'";
		TypedQuery<Member> jpqlQuery = em.createQuery(queryString, Member.class);
		
		//return jpqlQuery.getResultList();					//Maar dat is niet leuk
		Member member = jpqlQuery.getSingleResult();
		
		List<Member> members = new ArrayList<>();
		members.add(member);
		
		return members;
	}
	
	@Override
	public List<Book> getBooksOfMember(Long memberId) {
		Member member = null;
		try {
			member = em.find(Member.class, memberId);
		} catch (Exception e) {
			System.out.println("Er is iets fout gegaan tijdens het ophalen van de boeken van Member met id=" + memberId);
		}
		
		assert member != null;
		return new ArrayList<>(member.getBooks());		//Want getBooks() geeft een Set<Book> terug
	}
	
	//TODO verwijderen wanneer BookDaoService geimplementeerd is
	public void tempSaveBooks(Set<Book> books) {
		for (Book b : books)
			em.persist(b);
	}
}