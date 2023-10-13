import { TestBed } from '@angular/core/testing';

import { RegPontoService } from './reg-ponto.service';

describe('RegPontoService', () => {
  let service: RegPontoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RegPontoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
