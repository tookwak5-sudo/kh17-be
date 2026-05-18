//강좌 등록화면 검사 코드

$(function(){
    //상태 객체
    var state = {
        lectureTitleValid : false,
        lectureCategoryValid : false,
        lectureDurationValid : false,
        lecturePriceValid : false,
        lectureTypeValid : false,
        ok : function() {
            return Object.values(this)//이 객체의 모든 이름에 대한 값을 반환해라
            .filter(v => typeof v == "boolean") // boolean값만 추출해서
            .every(v => v === true); //모두 true인지 확인해서 반환해라
        }
    };
    //개별 입력창
    $("[name=lectureTitle]").on("blur", function(){
        var valid = $(this).val().length > 0;
        $(this).removeClass("success fail").addClass(valid ? "success" : "fail");
        state.lectureTitleValid = valid;
    });

    $("[name=lectureCategory]").on("input", function(){
        var regex = /^(이론|실습|시험)$/;
        var valid = regex.test($(this).val());
        $(this).removeClass("success fail").addClass(valid ? "success" : "fail");
        state.lectureCategoryValid = valid;
    });

    $("[name=lectureDuration]").on("blur", function(){
        var duration = parseInt($(this).val());
        var valid = duration <= 300 && duration % 30 == 0;
        $(this).removeClass("success fail").addClass(valid ? "success" : "fail");
        state.lectureDurationValid = valid;
    });
    $("[name=lecturePrice]").on("blur", function(){
        var price = parseInt($(this).val());
        var valid = price >= 0 && price <= 100000000;
        $(this).removeClass("success fail").addClass(valid ? "success" : "fail");
        state.lecturePriceValid = valid;
    });
    $("[name=lectureType]").on("input", function(){
        var regex = /^(온라인|오프라인|혼합)$/;
        var valid = regex.test($(this).val());
        $(this).removeClass("success fail").addClass(valid ? "success" : "fail");
        state.lectureTypeValid = valid;
    });

    //숫자 처리
    $("[name=lectureDuration]").on("input", function(){
        var originValue = $(this).val();
        var replaceValue = originValue.replace(/[^0-9]/g, "");
        $(this).val(parseInt(replaceValue || 0));
    });

    $("[name=lecturePrice]").on("input", function(){
        var originValue = $(this).val();
        var replaceValue = originValue.replace(/[^0-9]/g, "");
        $(this).val(parseInt(replaceValue || 0));
    });
    
    $(".form-check").on("submit", function(){
        $(this).find("select[name]").trigger("input");
        $("input[name], textarea[name]").trigger("blur");
        return state.ok();
    });

    //파일처리
    
});