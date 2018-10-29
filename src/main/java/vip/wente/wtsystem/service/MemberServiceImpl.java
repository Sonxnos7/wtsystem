package vip.wente.wtsystem.service;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vip.wente.wtsystem.dao.MemberDao;
import vip.wente.wtsystem.entity.Member;
import vip.wente.wtsystem.entity.Room;

import java.util.List;

/**
 * @program: WtSystem
 * @description: 会员管理
 * @author: Sonxnos7
 * @create: 2018-10-23 10:22
 **/
@Service("memberService")
public class MemberServiceImpl implements IMemberService {
    @Autowired
    private MemberDao memberDao;
    @Override
    public Integer add(Member member) {
        return memberDao.add(member);
    }

    @Override
    public List<Member> getAllMembers(Integer shopNumber, Integer offerset, Integer countPerpage) {
        String where="shopNumber='"+shopNumber+"'";
        String orderBy="lever asc,id asc";
        List<Member> list= memberDao.getMerbers(where,orderBy,null,null);
        return list;

    }
    //根据id获取会员信息
    @Override
    public Member getMemberById(Integer id, Integer shopNumber) {
        String where="shopNumber='"+shopNumber+"' and r.id="+id;
        return memberDao.getMerbers(where,null,null,null).get(0);
    }
    //搜索会员
    @Override
    public List<Member> getMemberBySearch(Integer shopNumber,String info) {
        String where="shopNumber='"+shopNumber+"' and r.name='"+info+"' or r.phone='"+info+"' or r.number='"+info+"'";
        return memberDao.getMerbers(where,null,null,null);
    }

    //修改
    @Override
    public Integer update(Member member) {
        return memberDao.update(member);
    }

    //删除
    @Override
    public Integer delete(Integer id, Integer shopNumber) {
        return memberDao.delete(id,shopNumber);
    }
    //总数
    @Override
    public Integer getMemberCount(Integer shopNumber) {
        return memberDao.getMemberCount(shopNumber);
    }
}
