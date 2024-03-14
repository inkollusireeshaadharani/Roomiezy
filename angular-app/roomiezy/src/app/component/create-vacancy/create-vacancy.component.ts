import { Component } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { VacancyserviceService } from 'src/app/vacancyservice.service';
import { Vacancy } from '../vacancy';

@Component({
  selector: 'app-create-vacancy',
  templateUrl: './create-vacancy.component.html',
  styleUrls: ['./create-vacancy.component.css']
})
export class CreateVacancyComponent {

  constructor(private vacancyservice: VacancyserviceService) {}
  
  vacancyform = new FormGroup({
    city: new FormControl(''),
    requirement: new FormControl(''),
    image: new FormControl(''),
    address: new FormControl(''),
    description: new FormControl(''),
  });

  addVacancy(vacancy: any) {
    
    return this.vacancyservice.AddVacancy(vacancy,1).subscribe((data: any) => {
      console.log("inside addVacancy()");
    });
    
  }


  onSubmit(){
    let vacancy: Vacancy = {
      city: this.vacancyform.get('city')?.value as string,
      requirement: this.vacancyform.get('requirement')?.value as string,
      image: this.vacancyform.get('image')?.value as string,
      address: this.vacancyform.get('address')?.value as string,
      description: this.vacancyform.get('description')?.value as string,
    };
    this.addVacancy(vacancy);
  }
}
