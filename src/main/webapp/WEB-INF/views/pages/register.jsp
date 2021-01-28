<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<div class="cell panel color-blue width-2of10 center">
    <div class="header">
        Регистрация
    </div>
    <div class="body">
        <div class="cell">
            <form action="#" method="post">


                        <div class="cell">
                            <label for="firstname">Имя<span class="color-red"> *</span></label>
                        </div>


                        <div class="cell">
                            <input type="text" id="firstname" placeholder="Ваше имя" data-required="true"
                                   data-error-message="1" class="text parsley-validated">
                        </div>



                        <div class="cell">
                            <label for="lastname">Фамилия<span class="color-red"> *</span></label>
                        </div>


                        <div class="cell">
                            <input type="text" id="lastname" placeholder="Ваша фамилия" data-required="true"
                                   data-error-message="2" class="text parsley-validated">
                        </div>





                        <div class="cell">
                            <label for="login">Логин<span class="color-red"> *</span></label>
                        </div>


                        <div class="cell">
                            <input type="text" id="login" placeholder="Логин" data-required="true"
                                   data-error-message="3" class="text parsley-validated">
                        </div>




                        <div class="cell">
                            <label for="password">Пароль<span class="color-red"> *</span></label>
                        </div>


                        <div class="cell">
                            <input type="password" id="password" placeholder="Пароль" data-required="true"
                                   data-error-message="4" class="text password parsley-validated">
                        </div>


            </form>
        </div>
    </div>
    <div class="footer">
        <div class="cell">
            <button class="button center color-white background-blue" type="submit">Зарегистрироваться</button>
        </div>
    </div>
</div>


