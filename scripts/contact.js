var $ = jQuery.noConflict();
var formSubmitted = 'false';

jQuery(document).ready(function($) {

    $('#formSuccessMessageWrap').hide(0);
    $('.formValidationError').fadeOut(0);

    // fields focus function starts
    $('input[type="text"], input[type="password"], textarea').focus(function() {
        if ($(this).val() == $(this).attr('data-dummy')) {
            $(this).val('');
        };
    });
    // fields focus function ends

    // fields blur function starts
    $('input, textarea').blur(function() {
        if ($(this).val() == '') {
            $(this).val($(this).attr('data-dummy'));
        };
    });
    // fields blur function ends

    // submit form data starts     
    function submitData(currentForm, formType) {
        // formSubmitted = 'true';
        event.preventDefault();

        // var data = (JSON.stringify($(this).serializeObject()));

        var formInput = JSON.stringify($('#' + currentForm).serializeObject());
        $.post($('#' + currentForm).attr('action'), formInput, function(data) {


            if (currentForm == "gradeForm") {
                $("#gradeLabel").text(data.grade);
                $("#totalMarks").text(data.totalMarks + " (Total Marks)");
                $("#percentage").text(data.percentage + "% (Marks in percentage)");

                $("#progress").addClass("p" + (100 - data.percentage));
                $("#gradeStatus").show();

            }


            if (currentForm == "totalMarksForm") {

                $("#totalMarksSaveStatus").text("Data Saved Successfully");

            }

            if (currentForm == "SfForm") {
                $("#SfSaveStatus").text("Scaling Factor Saved Successfully");
            }

            if (currentForm == "gcForm") {
                $("#gcSaveStatus").text("Grade Configuration Saved Successfully");
            }


        }).fail(function(error) {

            if (error.status == 200) {

                if (currentForm == "totalMarksForm") {

                    $("#totalMarksSaveStatus").text("Data Saved Successfully");

                }

                if (currentForm == "SfForm") {
                    $("#SfSaveStatus").text("Scaling Factor Saved Successfully");
                }

                if (currentForm == "gcForm") {
                    $("#gcSaveStatus").text("Grade Configuration Saved Successfully");
                }

            } else {

                if (currentForm == "gradeForm") {
                    $("#gradeLabel").text("One of the field have more than maximum allowed marks");
                    $("#gradeLabel").css({
                        'color': 'red',
                        'font-size': '150%'
                    });
                    $("#gradeStatus").show();
                }

                if (currentForm == "totalMarksForm") {
                    $("#totalMarksSaveStatus").text("Error in saving total marks");
                }

                if (currentForm == "SfForm") {
                    $("#SfSaveStatus").text("Error in saving sacling factor, please verify values");
                }

                if (currentForm == "gcForm") {
                    $("#gcSaveStatus").text("Error in saving grade configuration, please verify values");
                }


            }

        });

        // $.ajax({
        //             url:"api/login",
        //             type:"POST",
        //             data:data,
        //             contentType:"application/json",
        //             success: function(data){
        //                document.cookie = "userId=" + data.userId;
        //                document.cookie = "userName=" + data.userName;
        //                window.location = "/app";
        //             },
        //             error: function(errMsg, e, x){
        //                 alert("Invalid credentials");
        //             }
        //           });



    };


    $.fn.serializeObject = function() {
        var o = {};
        var a = this.serializeArray();
        $.each(a, function() {
            if (o[this.name]) {
                if (!o[this.name].push) {
                    o[this.name] = [o[this.name]];
                }
                o[this.name].push(this.value || '');
            } else {
                o[this.name] = this.value || '';
            }
        });
        return o;
    };


    // submit form data function starts 
    // validate form function starts
    function validateForm(currentForm, formType) {
        // hide any error messages starts
        $('.formValidationError').hide();
        $('.fieldHasError').removeClass('fieldHasError');
        // hide any error messages ends 
        $('#' + currentForm + ' .requiredField').each(function(i) {
            if ($(this).val() == '' || $(this).val() == $(this).attr('data-dummy')) {
                $(this).val($(this).attr('data-dummy'));
                $(this).focus();
                $(this).addClass('fieldHasError');
                $('#' + $(this).attr('id') + 'Error').fadeIn(300);
                return false;
            };
            if ($(this).hasClass('requiredEmailField')) {
                var emailReg = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;
                var tempField = '#' + $(this).attr('id');
                if (!emailReg.test($(tempField).val())) {
                    $(tempField).focus();
                    $(tempField).addClass('fieldHasError');
                    $(tempField + 'Error2').fadeIn(300);
                    return false;
                };
            };
            if (formSubmitted == 'false' && i == $('#' + currentForm + ' .requiredField').length - 1) {
                submitData(currentForm, formType);
            };
        });
    };
    // validate form function ends  

    // contact button function starts
    $('#totalMarksButton').click(function() {

        validateForm($(this).attr('data-formId'));

        return false;
    });

    $('#sfSave').click(function() {

        validateForm($(this).attr('data-formId'));

        return false;
    });


    $('#gcSave').click(function() {

        validateForm($(this).attr('data-formId'));

        return false;
    });

    // contact button function ends



});
/*////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////*/
/*//////////////////// Document Ready Function Ends                                                                       */
/*////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////*/
