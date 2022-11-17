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

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import nl.bld.bibliotheek.app.domain.Book;
import nl.bld.bibliotheek.app.domain.Member;

/**
 * TODO: ebben00: beschrijf deze klasse !
 *
 * @author ebben00
 */
public class MemberDaoServiceTests {
//	@Test
//	public void saveAndFindMemberTest() {
//		Book book = new Book("Jack Kerouac", "On the Road");
//		Set<Book> bookSet = new HashSet<>();
//		bookSet.add(book);
//		Member member1 = new Member("Niels", bookSet);
//		MemberDaoService memberDaoService = new MemberDaoService();
//
//		memberDaoService.tempSaveBooks(bookSet);		//TODO vervangen door BookDaoService
//		memberDaoService.save(member1);
//		List<Member> members = memberDaoService.getMemberByUserName("Niels");
//		Member member2 = members.get(0);
//
//		System.out.println("Username uit database = " + member2.getUserName());
//		assertThat(member1.getUserName()).isEqualTo(member2.getUserName());
//	}
//
//	@Test
//	public void findAndEditMemberTest() {
//		Book book = new Book("Jack Kerouac", "On the Road");
//		Set<Book> bookSet = new HashSet<>();
//		bookSet.add(book);
//		Member member1 = new Member("Niels", bookSet);
//		MemberDaoService memberDaoService = new MemberDaoService();
//
//		memberDaoService.tempSaveBooks(bookSet);		//TODO vervangen door BookDaoService
//		memberDaoService.save(member1);
//		List<Member> members = memberDaoService.getMemberByUserName("Niels");
//		Member member2 = members.get(0);
//		member2.setUserName("Joris");
//		memberDaoService.update(member2);
//		members = memberDaoService.getMemberByUserName("Joris");
//		Member member3 = members.get(0);
//
//		System.out.println("Username uit database = " + member3.getUserName());
//		assertThat(member2.getUserName()).isEqualTo(member3.getUserName());
//	}
//
//	@Test
//	public void saveAndRemoveMemberTest() {
//		Book book = new Book("Jack Kerouac", "On the Road");
//		Set<Book> bookSet = new HashSet<>();
//		bookSet.add(book);
//		Member member1 = new Member("Niels", bookSet);
//		MemberDaoService memberDaoService = new MemberDaoService();
//
//		memberDaoService.tempSaveBooks(bookSet);		//TODO vervangen door BookDaoService
//		memberDaoService.save(member1);
//		List<Member> members = memberDaoService.getMemberByUserName("Niels");
//		Member member2 = members.get(0);
//		memberDaoService.remove(member2);
//		members = memberDaoService.getMemberByUserName("Niels");
//
//		assertThat(members.size()).isEqualTo(0);
//	}
}