package models;

import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created with IntelliJ IDEA.
 * User: jefklak
 * Date: 11/10/12
 * Time: 09:51
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class User extends Model {

    @Id
    public Long id;
     public String name;


}
