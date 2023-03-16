function calcular(numero1, numero2, operação){
    if(operação == "somar"){
        return numero1 + numero2;
    } else if(operação == "subtrair"){
        return numero1 - numero2;
    } else if(operação == "multiplicar"){
        return numero1 * numero2;
    } else if(operação == "dividir"){
        return numero1 / numero2;
    }
}

console.log(calcular(50, 25, "multiplicar"));