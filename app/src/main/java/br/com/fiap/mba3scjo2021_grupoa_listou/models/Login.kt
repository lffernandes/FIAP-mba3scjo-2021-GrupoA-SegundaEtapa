package br.com.fiap.mba3scjo2021_grupoa_listou.models

class Login {
    constructor(user: String, password: String) {
        this.user = user
        this.password = password
    }

    var user: String
    var password: String
}