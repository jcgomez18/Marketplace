# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table productentity (
  id                        bigint not null,
  name                      varchar(255),
  stock                     integer,
  price                     float,
  available                 boolean,
  constraint pk_productentity primary key (id))
;

create table wishlistentity (
  id                        bigint not null,
  username                  varchar(255),
  constraint pk_wishlistentity primary key (id))
;

create sequence Product;

create sequence Wishlist;




# --- !Downs

drop table if exists productentity cascade;

drop table if exists wishlistentity cascade;

drop sequence if exists Product;

drop sequence if exists Wishlist;

