$(document).ready(function(){
		$('#userForm').bootstrapValidator({
			feedbackIcons: {
				valid: 'glyphicon glyphicon-ok',
				invalid: 'glyphicon glyphicon-remove',
				validating: 'glyphicon glyphicon-refresh'
			},
			fields: {
				nome: {
					container: '#infoNome',
					validators: {
						notEmpty: {
							message: 'Campo obbligatorio'
						},
						regexp: {
							regexp: /^[a-zA-Z,.']{2,30}$/,
							message: 'Da 2 a 30 caratteri (Solo lettere accettate)'
						}
					}
				},
				
				cognome: {
					container: '#infoCognome',
					validators: {
						notEmpty: {
							message: 'Campo obbligatorio'
						},
						regexp: {
							regexp: /^[a-zA-Z,.']{2,30}$/,
							message: 'Da 2 a 30 caratteri (Solo lettere accettate)'
						}
					}
				},
				
				indirizzo: {
					container: '#infoIndirizzo',
					validators: {
						notEmpty: {
							message: 'Campo obbligatorio'
						},
						regexp: {
							regexp: /^[a-zA-Z ,.']+[0-9]{1,4}$/,
							message: 'Inserire Via, Viale, o piazza con numero civico'
						}
					}
				},
				
				cap: {
					container: '#infoCap',
					validators: {
						notEmpty: {
							message: 'Campo obbligatorio'
						},
						regexp: {
							regexp: /^[0-9]{5}$/,
							message: 'Inserire le 5 cifre del CAP'
						}
					}
				},
				
				nascita: {
					container: '#infoNascita',
					validators: {
						notEmpty: {
							message: 'Campo obbligatorio'
						},
						date: {
							format: 'DD/MM/YYYY',
							message: 'Data non valida'
						}
					}
				},
				
				username: {
					container: '#infoUsername',
					validators: {
						notEmpty: {
							message: 'Campo obbligatorio'
						},
						regexp: {
							regexp: /^[a-zA-Z.0-9']{4,10}$/,
							message: 'Da 4 a 10 caratteri'
						}
					}
				},
				
				password: {
					container: '#infoPassword',
					validators: {
						notEmpty: {
							message: 'Campo obbligatorio'
						},
						regexp: {
							regexp: /^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])[a-zA-Z_.0-9']{8,20}$/,
							message: 'Da 8 a 20 caratteri, almeno un maiuscolo, un minuscolo ed un numero'
						}
					}
				},
				
				email: {
					container: '#infoEmail',
					validators: {
						notEmpty: {
							message: 'Campo obbligatorio'
						},
						regexp: {
							regexp: /^[\w\-\.\+]+\@[a-zA-Z0-9\.\-]+\.[a-zA-Z]{2,5}$/,
							message: 'La mail deve essere valida'
						}
					}
				}
				
				
			}
		})
		
	})