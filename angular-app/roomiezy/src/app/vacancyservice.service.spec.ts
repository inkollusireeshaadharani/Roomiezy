import { TestBed } from '@angular/core/testing';

import { VacancyserviceService } from './vacancyservice.service';

describe('VacancyserviceService', () => {
  let service: VacancyserviceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(VacancyserviceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
