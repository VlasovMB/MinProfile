<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<div class="cell panel color-blue width-2of10 center">
    <div class="header">
        Вход
    </div>
    <div class="body">
        <div class="cell">
            <form action="#" method="post">

                <div class="cell">
                    <label for="login">Логин<span class="color-red"> *</span></label>
                </div>


                <div class="cell">
                    <input type="text" id="login" placeholder="Логин" data-required="true"
                           data-error-message="Логин не может быть пустым" class="text width-fit parsley-validated">
                </div>


                <div class="cell">
                    <label for="password">Пароль<span class="color-red"> *</span></label>
                </div>

                <div class="cell">
                    <input type="password" id="password" placeholder="Пароль" data-required="true"
                           data-error-message="Пароль не может быть пустым" class="text password parsley-validated">
                </div>


            </form>
        </div>
    </div>
    <div class="footer">
        <div class="cell">
            <button class="button background-green color-white center" type="submit">Вход в личный кабинет</button>
        </div>
    </div>
</div>


