package lk.ijse.dep.web.library.business.custom.impl;

import lk.ijse.dep.web.library.business.custom.MemberBO;
import lk.ijse.dep.web.library.dto.MemberDTO;
import lk.ijse.dep.web.library.entity.Member;
import lk.ijse.dep.web.library.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
@Transactional
public class MemberBOImpl implements MemberBO {

    @Autowired
    MemberRepository memberRepository;

    @Override
    @Transactional(readOnly = true)
    public List<MemberDTO> getAllMembers() {
        ArrayList<MemberDTO> memberDTOS=new ArrayList<>();
        memberRepository.findAll().stream().forEach(member -> {
            memberDTOS.add(new MemberDTO(member.getId(),member.getName(),member.getAddress(),member.getContact()));
        });

        return memberDTOS;
    }

    @Override
    public MemberDTO getMember(String id) {
        try {
            Member m=memberRepository.findById(id).get();
            MemberDTO memberDTO=new MemberDTO(m.getId(),m.getName(),m.getContact(),m.getAddress());
            return memberDTO;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void saveMember(String id, String name, String contact, String address) {
        memberRepository.save(new Member(id,name,contact,address));
    }

    @Override
    public void updateMember(String id, String name, String con, String address) {
        memberRepository.save(new Member(id,name,con,address));

    }

    @Override
    public void deleteMember(String id) {
        memberRepository.deleteById(id);
    }
}
