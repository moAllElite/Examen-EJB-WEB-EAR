package com.groupeisi.controller;

import java.util.List;

import javax.ejb.Local;
@Local
public interface IRepository<T> {
	public int add(T t);
	public int  update(T t);
	public int delete(int id,T t);
	public List<T> liste(T t); 
	public T get (int id,T t);
}
