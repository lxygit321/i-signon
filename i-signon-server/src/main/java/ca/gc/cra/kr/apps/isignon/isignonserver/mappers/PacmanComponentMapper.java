package ca.gc.cra.kr.apps.isignon.isignonserver.mappers;

import ca.gc.cra.kr.apps.isignon.isignonserver.domain.PacmanComponent;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PacmanComponentMapper
{
    List<PacmanComponent> findAllComponents();
}
