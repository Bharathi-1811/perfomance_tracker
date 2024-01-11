import { AbstractControl, ValidatorFn } from "@angular/forms";



export function noSpaceAllowed(): ValidatorFn{

    return(control:AbstractControl):{[key:string]:boolean} | null =>{

        if(control.value!= null && control.value.indexOf(' ')!= -1)
        {
        return {noSpaceAllowed: true}
        }

        return null;

    }
}

export function checkZidValidation() : ValidatorFn{

    return(control:AbstractControl): {[key:string]:boolean} | null =>{


        if(control.value[0] === 'z' || control.value[0] === 'Z')
        {
            return null;
        }

        return {checkZidValidation: true}
    }

}

