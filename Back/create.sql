create sequence hibernate_sequence start 1 increment 1;
create table access (id int4 not null, access_time timestamp, eps_user varchar(255) not null, primary key (id));
create table appointment (id int4 not null, date_id int4 not null, doctor_eps_user varchar(255) not null, patient_eps_user varchar(255) not null, primary key (id));
create table certificate (id int4 not null, rute varchar(255), type varchar(255), patient varchar(255) not null, primary key (id));
create table city (id int4 not null, city varchar(255), department int4 not null, primary key (id));
create table date (id int4 not null, date date, description varchar(255), final_hour timestamp, initial_hour timestamp not null, status varchar(255), date_type int4 not null, headquarter_id int4 not null, primary key (id));
create table date_type (id int4 not null, description varchar(255), primary key (id));
create table department (id int4 not null, department varchar(255), primary key (id));
create table doctor (eps_user varchar(255) not null, email varchar(255), last_name varchar(255), name_doctor varchar(255), phone int4 not null, headquarter_id int4 not null, primary key (eps_user));
create table doctor_specialization (doctor_eps_user varchar(255) not null, specialization_id int4 not null);
create table eps_admin (eps_user varchar(255) not null, password varchar(255) not null, primary key (eps_user));
create table eps_user (id varchar(255) not null, password varchar(255) not null, rol int4 not null, primary key (id));
create table headquarter (id int4 not null, address varchar(255), name varchar(255), city int4 not null, primary key (id));
create table id_type (id int4 not null, type varchar(255), primary key (id));
create table laboratory_result (id int4 not null, archive_rute varchar(255), description varchar(255), date_id int4 not null, primary key (id));
create table ocupation (id int4 not null, ocupation varchar(255), primary key (id));
create table patient (eps_user varchar(255) not null, address varchar(255), birth_date date, email varchar(255) not null, genre varchar(255), last_name varchar(255), name varchar(255), phone varchar(10), regiment_type varchar(255), headquarter int4 not null, id_type int4 not null, ocupation int4 not null, primary key (eps_user));
create table specialization (id int4 not null, description varchar(255), primary key (id));
alter table if exists headquarter add constraint UK_ky8tuh4py23hqa7x4s9do4tqc unique (name);
alter table if exists patient add constraint UK_bawli8xm92f30ei6x9p3h8eju unique (email);
alter table if exists access add constraint FK8abmcl1ww4on9vfd3qupqsxch foreign key (eps_user) references eps_user;
alter table if exists appointment add constraint FKu58jkf20oe2si6w086grfro5 foreign key (date_id) references date;
alter table if exists appointment add constraint FK3r95wfx5dy6m35vbnp1vsr0xr foreign key (doctor_eps_user) references doctor;
alter table if exists appointment add constraint FK849906oowiyccv000ntn9bsub foreign key (patient_eps_user) references patient;
alter table if exists certificate add constraint FKoagaef7k3cihupigr0ex6tjen foreign key (patient) references patient;
alter table if exists city add constraint FK3nl8caw5c7peqo832g2p0ayq0 foreign key (department) references department;
alter table if exists date add constraint FKqvklyclyr1uwpxadgwi6nwbks foreign key (date_type) references date_type;
alter table if exists date add constraint FK71jxmq2fauvytq8hsbd9qa9my foreign key (headquarter_id) references headquarter;
alter table if exists doctor add constraint FKrrwr5lpp6pmjc5uholf748wuo foreign key (headquarter_id) references headquarter;
alter table if exists doctor add constraint FK5hfv7y5gj23eqcqph0t4d8jbh foreign key (eps_user) references eps_user;
alter table if exists doctor_specialization add constraint FK6jp5bem76u8ep90von0a1va0a foreign key (specialization_id) references specialization;
alter table if exists doctor_specialization add constraint FKri59acwd2tn40pbsqbs4vk0ql foreign key (doctor_eps_user) references doctor;
alter table if exists eps_admin add constraint FKpowi9pyf0wt2qgg7ih5q797as foreign key (eps_user) references eps_user;
alter table if exists headquarter add constraint FKt9tl2hbp4wdne1ju728uh1k4d foreign key (city) references city;
alter table if exists laboratory_result add constraint FKgb0sv8ex8518n9ko6xucna8tq foreign key (date_id) references date;
alter table if exists patient add constraint FKc6ytdg5aiprcwldiim0r0a19t foreign key (headquarter) references headquarter;
alter table if exists patient add constraint FK2riumgfovequpxsuous8cbbcp foreign key (id_type) references id_type;
alter table if exists patient add constraint FKkkbi2v9d6yq8whdu8l7sek06m foreign key (ocupation) references ocupation;
alter table if exists patient add constraint FKij377sx52to3m3yvahsx8otb4 foreign key (eps_user) references eps_user;
create sequence hibernate_sequence start 1 increment 1;
create table access (id int4 not null, access_time timestamp, eps_user varchar(255) not null, primary key (id));
create table appointment (id int4 not null, date_id int4 not null, doctor_eps_user varchar(255) not null, patient_eps_user varchar(255) not null, primary key (id));
create table certificate (id int4 not null, rute varchar(255), type varchar(255), patient varchar(255) not null, primary key (id));
create table city (id int4 not null, city varchar(255), department int4 not null, primary key (id));
create table date (id int4 not null, date date, description varchar(255), final_hour timestamp, initial_hour timestamp not null, status varchar(255), date_type int4 not null, headquarter_id int4 not null, primary key (id));
create table date_type (id int4 not null, description varchar(255), primary key (id));
create table department (id int4 not null, department varchar(255), primary key (id));
create table doctor (eps_user varchar(255) not null, email varchar(255), last_name varchar(255), name_doctor varchar(255), phone int4 not null, headquarter_id int4 not null, primary key (eps_user));
create table doctor_specialization (doctor_eps_user varchar(255) not null, specialization_id int4 not null);
create table eps_admin (eps_user varchar(255) not null, password varchar(255) not null, primary key (eps_user));
create table eps_user (id varchar(255) not null, password varchar(255) not null, rol int4 not null, primary key (id));
create table headquarter (id int4 not null, address varchar(255), name varchar(255), city int4 not null, primary key (id));
create table id_type (id int4 not null, type varchar(255), primary key (id));
create table laboratory_result (id int4 not null, archive_rute varchar(255), description varchar(255), date_id int4 not null, primary key (id));
create table ocupation (id int4 not null, ocupation varchar(255), primary key (id));
create table patient (eps_user varchar(255) not null, address varchar(255), birth_date date, email varchar(255) not null, genre varchar(255), last_name varchar(255), name varchar(255), phone varchar(10), regiment_type varchar(255), headquarter int4 not null, id_type int4 not null, ocupation int4 not null, primary key (eps_user));
create table specialization (id int4 not null, description varchar(255), primary key (id));
alter table if exists headquarter add constraint UK_ky8tuh4py23hqa7x4s9do4tqc unique (name);
alter table if exists patient add constraint UK_bawli8xm92f30ei6x9p3h8eju unique (email);
alter table if exists access add constraint FK8abmcl1ww4on9vfd3qupqsxch foreign key (eps_user) references eps_user;
alter table if exists appointment add constraint FKu58jkf20oe2si6w086grfro5 foreign key (date_id) references date;
alter table if exists appointment add constraint FK3r95wfx5dy6m35vbnp1vsr0xr foreign key (doctor_eps_user) references doctor;
alter table if exists appointment add constraint FK849906oowiyccv000ntn9bsub foreign key (patient_eps_user) references patient;
alter table if exists certificate add constraint FKoagaef7k3cihupigr0ex6tjen foreign key (patient) references patient;
alter table if exists city add constraint FK3nl8caw5c7peqo832g2p0ayq0 foreign key (department) references department;
alter table if exists date add constraint FKqvklyclyr1uwpxadgwi6nwbks foreign key (date_type) references date_type;
alter table if exists date add constraint FK71jxmq2fauvytq8hsbd9qa9my foreign key (headquarter_id) references headquarter;
alter table if exists doctor add constraint FKrrwr5lpp6pmjc5uholf748wuo foreign key (headquarter_id) references headquarter;
alter table if exists doctor add constraint FK5hfv7y5gj23eqcqph0t4d8jbh foreign key (eps_user) references eps_user;
alter table if exists doctor_specialization add constraint FK6jp5bem76u8ep90von0a1va0a foreign key (specialization_id) references specialization;
alter table if exists doctor_specialization add constraint FKri59acwd2tn40pbsqbs4vk0ql foreign key (doctor_eps_user) references doctor;
alter table if exists eps_admin add constraint FKpowi9pyf0wt2qgg7ih5q797as foreign key (eps_user) references eps_user;
alter table if exists headquarter add constraint FKt9tl2hbp4wdne1ju728uh1k4d foreign key (city) references city;
alter table if exists laboratory_result add constraint FKgb0sv8ex8518n9ko6xucna8tq foreign key (date_id) references date;
alter table if exists patient add constraint FKc6ytdg5aiprcwldiim0r0a19t foreign key (headquarter) references headquarter;
alter table if exists patient add constraint FK2riumgfovequpxsuous8cbbcp foreign key (id_type) references id_type;
alter table if exists patient add constraint FKkkbi2v9d6yq8whdu8l7sek06m foreign key (ocupation) references ocupation;
alter table if exists patient add constraint FKij377sx52to3m3yvahsx8otb4 foreign key (eps_user) references eps_user;
