import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegPontoComponent } from './reg-ponto.component';

describe('RegPontoComponent', () => {
  let component: RegPontoComponent;
  let fixture: ComponentFixture<RegPontoComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [RegPontoComponent]
    });
    fixture = TestBed.createComponent(RegPontoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
