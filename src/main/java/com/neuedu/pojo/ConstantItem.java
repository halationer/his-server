package com.neuedu.pojo;

import com.neuedu.util.BasePojo;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 常数项表
 * </p>
 *
 * @author jshand
 * @since 2020-08-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class ConstantItem extends BasePojo {

    private static final long serialVersionUID = 1L;

    /**
     * 类别id
     */
    private Integer typeId;

    /**
     * 常数项代码
     */
    private String code;

    /**
     * 常数项名称
     */
    private String name;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 是否有效，1 有效，0 失效
     */
    private Integer active;

    /**
     * 创建时间
     */
    private LocalDateTime createtime;


}
