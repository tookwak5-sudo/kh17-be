//국가 등록화면 검사코드
$(function(){
    //상태객체
    var state = {
        countryRegionValid : false,
        countryNameValid : false,
        countryCapitalValid : false,
        countryPopulationValid : false,
        ok : function() {
            return Object.values(this)//이 객체의 모든 이름에 대한 값을 반환해라
            .filter(v => typeof v == "boolean") // boolean값만 추출해서
            .every(v => v === true); //모두 true인지 확인해서 반환해라;
        }
    };

    //개별 입력창 검사
    $("[name=countryRegion]").on("input", function(){
        var regex = /^(아시아|아프리카|[남북]아메리카|유럽|오세아니아)$/;
        var valid = regex.test($(this).val());
        $(this).removeClass("success fail").addClass(valid ? "success" : "fail");

        state.countryRegionValid = valid;
    });
    $("[name=countryName]").on("blur", function(){
        var regex = /^[가-힣]{1,10}$/;
        var valid = regex.test($(this).val());
        $(this).removeClass("success fail").addClass(valid ? "success" : "fail");
        state.countryNameValid = valid;
    });

    $("[name=countryCapital]").on("blur", function(){
        // var valid = this.value.length > 0;
        var valid = $(this).val().length > 0;
        $(this).removeClass("success fail").addClass(valid ? "success" : "fail");
        state.countryCapitalValid = valid; //state에 보관
    });

    $("[name=countryPopulation]").on("blur", function(){
        var value = $(this).val();
        var valid = value.length > 0 && parseInt(value) > 0;
        $(this).removeClass("success fail").addClass(valid ? "success" : "fail");
        state.countryPopulationValid = valid; // 외부 state에 결과 저장
        
    });

    //숫자 입력창 처리
    $("[inputmode=numeric]").on("input", function(){
        var regex = /[^0-9]+/g; //g(lobal)를 붙이면 개수 제한 없이 다 적용됨
        //var replacement = this.value.replace(regex, "");
        var replacement = $(this).val().replace(regex, "");
        //this.value = replacement;//
        $(this).value = replacement;
    });

    //폼 검사
    $(".form-check").on("submit", function(e){
        //화면처리(이벤트 트리거)
        $(this).find("select[name]").trigger("input"); 
        $("input[name], textarea[name]").trigger("blur");

        return state.ok(); //stat.ok() 상태에 따라 전송해!
    });
});