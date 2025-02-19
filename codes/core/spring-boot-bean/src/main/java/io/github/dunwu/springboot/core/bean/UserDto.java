package io.github.dunwu.springboot.core.bean;

import lombok.Data;
import lombok.ToString;

/**
 * @author Zhang Peng
 * @since 2018-11-02
 */
@Data
@ToString
public class UserDto {

    private long id;

    private String name;

    private InfoDto infoDTO;

}
