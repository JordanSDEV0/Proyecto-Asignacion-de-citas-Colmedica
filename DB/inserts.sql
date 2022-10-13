INSERT INTO public.date_type
(id, description)
VALUES(1, 'example date type');

INSERT INTO public.department
(id, department)
VALUES(1, 'department example');

INSERT INTO public.city
(id, city, department)
VALUES(1, 'city example', 1);

INSERT INTO public.headquarter
(id, address, "name", city)
VALUES(1, 'address example', 'sede example', 1);

INSERT INTO public.id_type
(id, "type")
VALUES(1, 'type example');

INSERT INTO public.ocupation
(id, ocupation)
VALUES(1, 'ocupation example');