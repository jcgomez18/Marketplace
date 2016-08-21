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

create table itementity (
  id                        bigint not null,
  product_id                bigint not null,
  wishlist_id               bigint not null,
  quantity                  integer,
  constraint pk_itementity primary key (id)
  constraint fk_productentity foreing key(product_id)
  constraint fk_wishlistentity foreing key(wishlist_id))
;

create sequence Product;

create sequence Wishlist;

create sequence Item;


# --- !Downs

drop table if exists productentity cascade;

drop table if exists wishlistentity cascade;

drop table if exists itementity cascade;

drop sequence if exists Product;

drop sequence if exists Wishlist;

drop sequence if exists Item;

