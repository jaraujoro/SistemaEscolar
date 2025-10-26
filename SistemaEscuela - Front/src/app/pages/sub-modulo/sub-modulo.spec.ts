import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SubModulo } from './sub-modulo';

describe('SubModulo', () => {
  let component: SubModulo;
  let fixture: ComponentFixture<SubModulo>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SubModulo]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SubModulo);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
