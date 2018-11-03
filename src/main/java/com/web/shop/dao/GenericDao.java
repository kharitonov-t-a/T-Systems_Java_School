package com.web.shop.dao;

import com.web.shop.exceptions.SaveUserException;
import com.web.shop.model.User;

import java.io.Serializable;
import java.util.List;

public interface GenericDao <T, PK extends Serializable> {

    /** Сохранить объект newInstance в базе данных */
    void create(T newInstance);

    /** Извлечь объект, предварительно сохраненный в базе данных, используя
     *   указанный id в качестве первичного ключа
     */
    T findById(PK id);

    /** Сохранить изменения, сделанные в объекте.  */
    void update(T transientObject);

    /** Удалить объект из базы данных */
    void delete(T persistentObject);

    /** Удалить объект из базы данных по ID*/
    void deleteById(PK id);

    List<T> findAll();
}