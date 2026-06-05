package org.zerock.ex00.mappers;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.zerock.ex00.domain.BoardVO;
import org.zerock.ex00.domain.Criteria;

import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j2
public class BoardMapperTests {
    @Autowired(required = false)
    BoardMapper boardMapper;

    @Test
    public void test1(){
        log.info(boardMapper);
    }

    @Test
    public void testList(){
        boardMapper.getList().forEach(boardVO -> log.info(boardVO));
    }

    @Test
    public void testInsert(){
        BoardVO boardVO = new BoardVO();
        boardVO.setTitle("NewTest");
        boardVO.setContent("New Test...");
        boardVO.setWriter("newbie");

        log.info("COUNT: " + boardMapper.insert(boardVO));
        log.info("BNO: " + boardVO.getBno());
    }

    @Test
    public void testSelect(){
        Long bno = 9L;
        log.info(boardMapper.select(bno));
    }

    @Test
    public void testUpdate(){
        BoardVO boardVO = new BoardVO();
        boardVO.setTitle("Update Title");
        boardVO.setContent("Update Content");
        boardVO.setBno(9L);

        int updateContent = boardMapper.update(boardVO);
        log.info("update: " +updateContent);
    }

    @Test
    public void testPage(){
        Criteria criteria = new Criteria();
        // 아무것도 안해주면 1페이지에 10개만 나오는게 기본설정값임.

        criteria.setPageNum(2);
        criteria.setTypes(new String[]{"T", "C", "W"});
        criteria.setKeyword("1");
        List<BoardVO> list = boardMapper.getPage(criteria);
        list.forEach(boardVO -> log.info(boardVO));
    }
}
