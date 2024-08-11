/**
 * Validação de formulário
 * @author Paulo Henrique
 * 
 */
function validar() {
	let nome = frmContato.nome.value.trim()
	let fone = frmContato.fone.value.trim()
	let email = frmContato.email.value.trim()

	if (nome === "") {
		alert("Preencha o campo nome!")
		frmContato.nome.focus()
		return false
	}
	else if (fone === "") {
		alert("Preencha o campo fone!")
		frmContato.fone.focus()
		return false
	}
	else if (email === "") {
		alert("Preencha o campo email!")
		frmContato.email.focus()
		return false
	}
	else { return true }
}