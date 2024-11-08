PGDMP                  
    |         	   RogerCard    17.0    17.0     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                           false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                           false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                           false            �           1262    16391 	   RogerCard    DATABASE     �   CREATE DATABASE "RogerCard" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Portuguese_Brazil.1252';
    DROP DATABASE "RogerCard";
                     postgres    false            �            1259    16403    creditcarddb    TABLE     �   CREATE TABLE public.creditcarddb (
    creditcardid bigint NOT NULL,
    creditcardnumber integer,
    creditcardlimit bigint,
    creditcardduedate date,
    creditcardinvoicevalue bigint
);
     DROP TABLE public.creditcarddb;
       public         heap r       postgres    false            �            1259    16402    creditcarddb_creditcardid_seq    SEQUENCE     �   CREATE SEQUENCE public.creditcarddb_creditcardid_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 4   DROP SEQUENCE public.creditcarddb_creditcardid_seq;
       public               postgres    false    220            �           0    0    creditcarddb_creditcardid_seq    SEQUENCE OWNED BY     _   ALTER SEQUENCE public.creditcarddb_creditcardid_seq OWNED BY public.creditcarddb.creditcardid;
          public               postgres    false    219            �            1259    16396    userdb    TABLE     �   CREATE TABLE public.userdb (
    userid bigint NOT NULL,
    username character varying(50),
    useremail character varying(50),
    userpassword character varying(50)
);
    DROP TABLE public.userdb;
       public         heap r       postgres    false            �            1259    16395    userdb_userid_seq    SEQUENCE     z   CREATE SEQUENCE public.userdb_userid_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public.userdb_userid_seq;
       public               postgres    false    218            �           0    0    userdb_userid_seq    SEQUENCE OWNED BY     G   ALTER SEQUENCE public.userdb_userid_seq OWNED BY public.userdb.userid;
          public               postgres    false    217            '           2604    16406    creditcarddb creditcardid    DEFAULT     �   ALTER TABLE ONLY public.creditcarddb ALTER COLUMN creditcardid SET DEFAULT nextval('public.creditcarddb_creditcardid_seq'::regclass);
 H   ALTER TABLE public.creditcarddb ALTER COLUMN creditcardid DROP DEFAULT;
       public               postgres    false    220    219    220            &           2604    16399    userdb userid    DEFAULT     n   ALTER TABLE ONLY public.userdb ALTER COLUMN userid SET DEFAULT nextval('public.userdb_userid_seq'::regclass);
 <   ALTER TABLE public.userdb ALTER COLUMN userid DROP DEFAULT;
       public               postgres    false    217    218    218            �          0    16403    creditcarddb 
   TABLE DATA           �   COPY public.creditcarddb (creditcardid, creditcardnumber, creditcardlimit, creditcardduedate, creditcardinvoicevalue) FROM stdin;
    public               postgres    false    220   �       �          0    16396    userdb 
   TABLE DATA           K   COPY public.userdb (userid, username, useremail, userpassword) FROM stdin;
    public               postgres    false    218   �       �           0    0    creditcarddb_creditcardid_seq    SEQUENCE SET     L   SELECT pg_catalog.setval('public.creditcarddb_creditcardid_seq', 1, false);
          public               postgres    false    219            �           0    0    userdb_userid_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.userdb_userid_seq', 4, true);
          public               postgres    false    217            +           2606    16408    creditcarddb creditcarddb_pkey 
   CONSTRAINT     f   ALTER TABLE ONLY public.creditcarddb
    ADD CONSTRAINT creditcarddb_pkey PRIMARY KEY (creditcardid);
 H   ALTER TABLE ONLY public.creditcarddb DROP CONSTRAINT creditcarddb_pkey;
       public                 postgres    false    220            )           2606    16401    userdb userdb_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.userdb
    ADD CONSTRAINT userdb_pkey PRIMARY KEY (userid);
 <   ALTER TABLE ONLY public.userdb DROP CONSTRAINT userdb_pkey;
       public                 postgres    false    218            �      x������ � �      �   4   x�3����M�R�t�M�����y�V
\F�$�qI�p����"�\1z\\\ Tm     