package lk.ijse.dep.web.library.business.custom;

import lk.ijse.dep.web.library.business.SuperBO;
import lk.ijse.dep.web.library.dto.MemberDTO;

import java.util.List;

public interface MemberBO extends SuperBO {
    List<MemberDTO> getAllMembers();

    MemberDTO getMember(String id);

    void saveMember(String id, String name, String contact, String address);

    void updateMember(String id, String name, String con, String address);

    void deleteMember(String id);
}
