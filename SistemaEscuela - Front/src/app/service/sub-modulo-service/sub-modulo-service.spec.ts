import { TestBed } from '@angular/core/testing';

import { SubModuloService } from './sub-modulo-service';

describe('SubModuloService', () => {
  let service: SubModuloService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SubModuloService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
