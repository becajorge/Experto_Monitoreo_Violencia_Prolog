
:- use_module(library(jpl)).
:- dynamic si/1,no/1.


start:-sleep(0.1),
		write('----------------------------'),nl,
		sleep(0.1),
		write('****************************'),nl,
		sleep(0.2),
		write("##|| SISTEMA EXPERTO MONITOREO DE VIOLENCIA ESCOLAR ||##"),nl,
		sleep(0.1),
		write('****************************'),nl,
		sleep(0.1),
		write('----------------------------'),nl,nl,nl,
        /*write("Bienvenido, esperamos que se encuentre bien ¿Cuál es su nombre?: "),
        read(Estudiante),*/


		interface2.


       /* hipotesis(Estudiante,Actor),
        write(Estudiante),write(', su Estudiante '), write(' probablemente sea '),write(Actor),write('.'),undo,
		nl,nl,nl,
		sleep(0.1),
		write('********************************'),nl,
		sleep(0.2),
		write("##|| Gracias por probar nuestro sistema experto, vuelva pronto ||##"),nl,
		sleep(0.1),
		write('********************************),nl.*/


    condicion(Estudiante,sin_empatia) :- verificar(Estudiante," ¿Si tu amigo se cae, lo ayudarias? responde con un (si/no)").

    condicion(Estudiante,siente_tristeza) :- verificar(Estudiante," ¿Te sientes triste? responde con un (si/no)").

    condicion(Estudiante,siente_presion) :- verificar(Estudiante," ¿Te has sentido presionado ultimadmente? responde con un (si/no)").

    condicion(Estudiante,inseguro) :- verificar(Estudiante," ¿Te sientes seguro estando aqui? responde con un (si/no)").

    condicion(Estudiante,caracater_dominante) :- verificar(Estudiante," ¿Tu eres el que manda en el salón? responde con un (si/no)").

    condicion(Estudiante,sin_intervencion) :- verificar(Estudiante," ¿Si observas que un compañero u otra persona molesta a alguien, avisarias a tu docente? (si/no)?").

    condicion(Estudiante,rechazo_escuela) :- verificar(Estudiante," ¿Te gusta venir al colegio? responde con un (si/no)").

    condicion(Estudiante,sin_solidaridad) :- verificar(Estudiante," ¿Alguna vez viste a tu compañero hacer bullying y no le contaste a nadie (si/no)").

    condicion(Estudiante,siente_ira) :- verificar(Estudiante," tiene un estornudo (si/no) ?").

    condicion(Estudiante,siente_miedo) :- verificar(Estudiante," tiene un tos seca(si/no) ?").

	/*condicion(_,"Lo siento, parece que no puedo diagnosticar a tu Estudiante.").*/


    hipotesis(Estudiante, Victima) :-
        condicion(Estudiante,siente_tristeza),
        condicion(Estudiante,inseguro),
        condicion(Estudiante,siente_presion),
        condicion(Estudiante,perdida_respiratoria),
        condicion(Estudiante,siente_miedo).

    hipotesis(Estudiante, Agresor) :-
        condicion(Estudiante,sin_empatia),
        condicion(Estudiante,siente_presion),
        condicion(Estudiante,caracater_dominante),
        condicion(Estudiante,siente_ira).

    hipotesis(Estudiante, Observador) :-
        condicion(Estudiante,sin_empatia),
        condicion(Estudiante,siente_presion),
        condicion(Estudiante,sin_intervencion),
        condicion(Estudiante,siente_miedo),
        condicion(Estudiante,sin_solidaridad).



	hipotesis(_,"actor. Pero lo siento, parece que no puedo diagnosticart a tu Estudiante").

    response(Reply) :-
        read(Reply),
        write(Reply),nl.

preguntar(Estudiante,Pregunta) :-
	interface(', usted',Estudiante,Pregunta),
	write('Loading.'),nl,
	sleep(0.2),
	write('Loading..'),nl,
	sleep(0.2),
	write('Loading...'),nl,
	sleep(0.2),
    nl.


verificar(P,S) :-
   (si(S)
    ->
    true ;
    (si(S)
     ->
     fail ;
     preguntar(P,S))).

undo :- retract(si(_)),fail.
undo :- retract(no(_)),fail.
undo.


pt(Estudiante):-
                hipotesis(Estudiante,Actor),
		interface3(Estudiante,', tu Estudiante probablemente sea: ',Actor,'.'),
        write(Estudiante),write(', tu Estudiante probablemente sea: '),write(Actor),write('.'),undo,end.

end :-
		nl,nl,nl,
		sleep(0.7),
		write('**************'),nl,
		sleep(0.4),
		write("###|| Gracias por probar nuestro test, vuelva pronto  ||###"),nl,
		sleep(0.4),
		write('**************'),nl.

interface(X,Y,Z) :-
	atom_concat(Y,X, FAtom),
	atom_concat(FAtom,Z,FinalAtom),
	jpl_new('javax.swing.JFrame', ['Bullying'], F),
	jpl_new('javax.swing.JLabel',['--- Test para el monitoreo de la violencia y acoso escolar ---'],LBL),
	jpl_new('javax.swing.JPanel',[],Pan),
	jpl_call(Pan,add,[LBL],_),
	jpl_call(F,add,[Pan],_),
	jpl_call(F, setLocation, [400,300], _),
	jpl_call(F, setSize, [400,300], _),
	jpl_call(F, setVisible, [@(true)], _),
	jpl_call(F, toFront, [], _),
	jpl_call('javax.swing.JOptionPane', showInputDialog, [F,FinalAtom], N),
	jpl_call(F, dispose, [], _),
	write(N),nl,
	( (N == si ; N == s)
      ->
       assert(si(Z)) ;
       assert(no(Z)), fail).

interface2 :-
	jpl_new('javax.swing.JFrame', ['Bullying'], F),
	jpl_new('javax.swing.JLabel',['--- Test para el monitoreo de la violencia y acoso escolar ---'],LBL),
	jpl_new('javax.swing.JPanel',[],Pan),
	jpl_call(Pan,add,[LBL],_),
	jpl_call(F,add,[Pan],_),
	jpl_call(F, setLocation, [400,300], _),
	jpl_call(F, setSize, [400,300], _),
	jpl_call(F, setVisible, [@(true)], _),
	jpl_call(F, toFront, [], _),
	jpl_call('javax.swing.JOptionPane', showInputDialog, [F,'Hola. ¿Como estas? Primero que nada dime tu nombre por favor'], N),
	jpl_call(F, dispose, [], _),
	/*write(N),nl,*/
	(	N == @(null)
		->	write('Cancelaste'),interface3('Cancelaste. ','gracias ','por ','usarme.'),end,fail
		;	write("Bienvenido, esperamos que se encuentre bien ¿Cuál es su nombre?:"),write(N),nl,pt(N)
	).


interface3(P,W1,D,W2) :-
	atom_concat(P,W1, A),
	atom_concat(A,D,B),
	atom_concat(B,W2,W3),
	jpl_new('javax.swing.JFrame', ['Bullying'], F),
	jpl_new('javax.swing.JLabel',['--- Test para el monitoreo de la violencia y acoso escolar ---'],LBL),
	jpl_new('javax.swing.JPanel',[],Pan),
	jpl_call(Pan,add,[LBL],_),
	jpl_call(F,add,[Pan],_),
	jpl_call(F, setLocation, [400,300], _),
	jpl_call(F, setSize, [400,300], _),
	jpl_call(F, setVisible, [@(true)], _),
	jpl_call(F, toFront, [], _),
	jpl_call('javax.swing.JOptionPane', showMessageDialog, [F,W3], N),
	jpl_call(F, dispose, [], _),
	/*write(N),nl,*/
	(	N == @(void)
		->	write('')
		;	write("")
	).

help :- write("Para iniciar el sistema experto, escriba 'iniciar'. y presione la tecla Enter").
