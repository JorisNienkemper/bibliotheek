/*
 *
 *  ---------------------------------------------------------------------------------------------------------
 *              Titel: MemberDaoServiceTests.java
 *             Auteur: ebben00
 *    Creatietijdstip: 17/11/2022 14:35
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

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import nl.bld.bibliotheek.app.domain.Book;
import nl.bld.bibliotheek.app.domain.Member;

import jakarta.persistence.NoResultException;

/**
 * TODO: ebben00: beschrijf deze klasse !
 *
 * @author ebben00
 */
public class MemberDaoServiceTests {
	private MemberDaoService memberDaoService = new MemberDaoService();
	
	@Test
	public void saveAndFindMemberTest() {
		Member member1 = makeAndSaveNewBookAndMember();
		
		List<Member> members = memberDaoService.getMemberByUserName("Niels");
		Member member2 = members.get(0);

		//System.out.println("Username uit database = " + member2.getUserName());
		assertThat(member1.getUserName()).isEqualTo(member2.getUserName());
	}

	@Test
	public void findAndEditMemberTest() {
		makeAndSaveNewBookAndMember();
		
		List<Member> members = memberDaoService.getMemberByUserName("Niels");
		Member member2 = members.get(0);
		member2.setUserName("Joris");
		memberDaoService.update(member2);
		members = memberDaoService.getMemberByUserName("Joris");
		Member member3 = members.get(0);

		//System.out.println("Username uit database = " + member3.getUserName());
		assertThat(member2.getUserName()).isEqualTo(member3.getUserName());
	}

	@Test
	public void saveAndRemoveMemberTest() {
		makeAndSaveNewBookAndMember();
		
		List<Member> members = memberDaoService.getMemberByUserName("Niels");
		Member member2 = members.get(0);
		memberDaoService.remove(member2);
		
		NoResultException thrown = assertThrows(NoResultException.class, () -> {			//N.B. JUnit5 assertion, NIET jcore
			List<Member> unfindableMember = memberDaoService.getMemberByUserName("Niels");
		});
	}
	
	@Test
	public void getMemberByIdTest() {
		Member member1 = makeAndSaveNewBookAndMember();
		Member member2 = memberDaoService.getMemberById(member1.getId());
		
		assertThat(member1).isEqualTo(member2);
	}
	
	@Test
	public void getBooksOfMember() {
		//TODO Implement
	}
	
	private Member makeAndSaveNewBookAndMember() {
		Book book = new Book("Jack Kerouac", "On the Road");
		Set<Book> bookSet = new HashSet<>();
		bookSet.add(book);
		Member member1 = new Member("Niels", bookSet);
		
		memberDaoService.tempSaveBooks(bookSet);		//TODO vervangen door BookDaoService
		memberDaoService.save(member1);
		
		return member1;
	}
}