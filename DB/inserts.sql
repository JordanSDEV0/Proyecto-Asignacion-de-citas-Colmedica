/*Adding a single record to a table using append query syntax (public.date_type)*/
INSERT INTO public.date_type
(id, description)
VALUES(1, 'example date type');
/*Adding a single record to a table using append query syntax (public.department)*/
INSERT INTO public.department
(id, department)
VALUES(1, 'department example');
/*Adding a single record to a table using append query syntax (public.city)*/
INSERT INTO public.city
(id, city, department)
VALUES(1, 'city example', 1);
/*Adding a single record to a table using append query syntax (public.headquarter)*/
INSERT INTO public.headquarter
(id, address, "name", city)
VALUES(1, 'address example', 'sede example', 1);
/*Adding a single record to a table using append query syntax (public.id_type)*/
INSERT INTO public.id_type
(id, "type")
VALUES(1, 'type example');
/*Adding a single record to a table using append query syntax (public.ocupation)*/
INSERT INTO public.ocupation
(id, ocupation)
VALUES(1, 'ocupation example');