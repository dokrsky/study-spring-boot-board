package com.example.board.board.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.board.board.entity.BoardEntity;
import com.example.board.board.entity.BoardFileEntity;

import java.util.List;

public interface JpaBoardRepository extends CrudRepository<BoardEntity, Integer> {

    List<BoardEntity> findAllByOrderByBoardIdxDesc();

    @Query("SELECT file FROM BoardFileEntity file WHERE board_idx = :boardIdx AND idx = :idx")
    BoardFileEntity findBoardFile(@Param("boardIdx") int boardIdx, @Param("idx") int idx);
}
