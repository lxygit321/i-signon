package ca.gc.cra.kr.apps.isignon.isignonserver.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class PacmanComponent implements Serializable
{
    private String componentId;
    private int handle;
    private String componentName;
}
