function login(obj){
    console.log(obj.id);
    if(obj.id === 'btn-acessar-conta')
        formDisplay('block','none');
    else
        formDisplay('none','block');
}

function formDisplay(inSetting1, inSetting2){
    document.getElementById('form-home').style='display:none !important;';
    document.getElementById('form-login').style='display:'+inSetting1+' !important;';
    document.getElementById('form-cadastro').style='display:'+inSetting2+' !important;';

}

function theForm(id, inSetting, id2, inSetting2){
    document.getElementById(id).style='display:'+inSetting+' !important;';
    document.getElementById(id2).style='display:'+inSetting2+' !important;';
}