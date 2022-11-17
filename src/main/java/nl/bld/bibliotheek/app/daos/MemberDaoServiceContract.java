package nl.bld.bibliotheek.app.daos;


import nl.bld.bibliotheek.app.domain.Book;
import nl.bld.bibliotheek.app.domain.Member;

import java.util.List;

public interface MemberDaoServiceContract {

    void save(Member member);

    void update(Member member);

    void remove(Member member);

    Member getMemberById(Long id);

    List<Member> getMemberByUserName(String userName);

    List<Book> getBooksOfMember(Long memberId);
}