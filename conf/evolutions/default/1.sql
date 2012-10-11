# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table horse (
  id                        bigint not null,
  name                      varchar(255),
  price                     integer,
  constraint pk_horse primary key (id))
;

create table player (
  id                        bigint not null,
  name                      varchar(255),
  constraint pk_player primary key (id))
;

create sequence horse_seq;

create sequence player_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists horse;

drop table if exists player;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists horse_seq;

drop sequence if exists player_seq;

