package org.zerock.ex00.mappers;

import org.apache.ibatis.annotations.Param;
import org.zerock.ex00.domain.Criteria;
import org.zerock.ex00.domain.ReplyVO;

import java.util.List;

public interface ReplyMapper {
    Long insert(ReplyVO replyVO);

    ReplyVO selectOne(Long rno);

    int deleteOne(Long rno);
    int updateOne(ReplyVO replyVO);

    // MyBatis는 원래 파라미터를 1개밖에 못받는데 이를 해결하기 위해 @Param어노테이션을 사용하면 Map처럼 사용가능하다.
    List<ReplyVO> getList(@Param("cri") Criteria cri, @Param("bno") Long bno);

    int getTotal(@Param("cri") Criteria cri, @Param("bno") Long bno);
}
