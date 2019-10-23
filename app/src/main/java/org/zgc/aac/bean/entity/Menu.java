package org.zgc.aac.bean.entity;

import androidx.databinding.ObservableField;

/**
 * Author: ZGC
 * Time: 2019/10/21 10:06
 * Description:
 */
public class Menu {
    private String name;

    public Menu(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
