package org.zerock.ex00.mappers;

import org.zerock.ex00.domain.BoardVO;
import org.zerock.ex00.domain.Criteria;

import java.util.List;

public interface BoardMapper {
    List<BoardVO> getList();

    List<BoardVO> getPage(Criteria criteria);

    int getTotal(Criteria criteria);

    int insert(BoardVO boardVO);

    BoardVO select(Long bno);

    int update(BoardVO boardVO);
}
