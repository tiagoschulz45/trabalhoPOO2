/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dataservices.dao;

import java.util.List;

public interface IDAO<T> {
    public void save(T t);
    public List<T> list();
    public void remove(T t);
    public void update(T t);
}
