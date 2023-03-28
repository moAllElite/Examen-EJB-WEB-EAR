package com.groupeisi.controller;

import javax.ejb.Local;

import com.groupeisi.entities.Contact;

@Local
public interface IContactLocal extends IRepository<Contact>{

}
