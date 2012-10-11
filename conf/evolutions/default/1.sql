# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table horse (
  id                        bigint not null,
  name                      varchar(255),
  price                     integer,
  player_id                 bigint,
  constraint pk_horse primary key (id))
;

create table player (
  id                        bigint not null,
  username                  varchar(255),
  password                  varchar(255),
  cash_amount               integer,
  stock_id                  bigint,
  constraint pk_player primary key (id))
;

create table race (
  id                        bigint not null,
  start_date                timestamp,
  constraint pk_race primary key (id))
;

create table stock (
  id                        bigint not null,
  constraint pk_stock primary key (id))
;

create sequence horse_seq;

create sequence player_seq;

create sequence race_seq;

create sequence stock_seq;

alter table horse add constraint fk_horse_player_1 foreign key (player_id) references player (id) on delete restrict on update restrict;
create index ix_horse_player_1 on horse (player_id);
alter table player add constraint fk_player_stock_2 foreign key (stock_id) references stock (id) on delete restrict on update restrict;
create index ix_player_stock_2 on player (stock_id);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists horse;

drop table if exists player;

drop table if exists race;

drop table if exists stock;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists horse_seq;

drop sequence if exists player_seq;

drop sequence if exists race_seq;

drop sequence if exists stock_seq;

