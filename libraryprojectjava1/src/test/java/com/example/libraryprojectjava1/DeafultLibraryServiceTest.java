package com.example.libraryprojectjava1;

import com.example.libraryprojectjava1.pojo.entity.Library;
import com.example.libraryprojectjava1.pojo.entity.Member;
import com.example.libraryprojectjava1.repository.LibraryRepository;
import com.example.libraryprojectjava1.repository.MemberRepository;
import com.example.libraryprojectjava1.service.DefaultLibraryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DefaultLibraryServiceTest {

    @Mock
    private LibraryRepository libraryRepository;

    @Mock
    private MemberRepository memberRepository;

    @InjectMocks
    private DefaultLibraryService libraryService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createLibrary_ShouldReturnSavedLibrary() {
        Library library = new Library();
        library.setName("Test Library");

        when(libraryRepository.save(library)).thenReturn(library);

        Library result = libraryService.create(library);

        assertNotNull(result);
        assertEquals("Test Library", result.getName());
        verify(libraryRepository, times(1)).save(library);
    }

    @Test
    void findById_ShouldReturnLibrary_WhenExists() {
        Library library = new Library();
        library.setId(1);

        when(libraryRepository.findById(1)).thenReturn(Optional.of(library));

        Optional<Library> result = libraryService.findById(1);

        assertTrue(result.isPresent());
        assertEquals(1, result.get().getId());
        verify(libraryRepository, times(1)).findById(1);
    }

    @Test
    void findAll_ShouldReturnListOfLibraries() {
        Library library1 = new Library();
        Library library2 = new Library();
        when(libraryRepository.findAll()).thenReturn(Arrays.asList(library1, library2));

        List<Library> result = libraryService.findAll();

        assertEquals(2, result.size());
        verify(libraryRepository, times(1)).findAll();
    }

    @Test
    void deleteLibrary_ShouldCallRepositoryDelete() {
        doNothing().when(libraryRepository).deleteById(1);

        libraryService.deleteLibrary(1);

        verify(libraryRepository, times(1)).deleteById(1);
    }

    @Test
    void updateLibrary_ShouldReturnUpdatedLibrary() {
        Library library = new Library();
        library.setId(1);
        library.setName("Updated Library");

        when(libraryRepository.save(library)).thenReturn(library);

        Library result = libraryService.update(library);

        assertNotNull(result);
        assertEquals("Updated Library", result.getName());
        verify(libraryRepository, times(1)).save(library);
    }


//    @InjectMocks
//    private DefaultLibraryService defaultLibraryService;
//
//    @Test
//    public void findByAddress_ShouldReturnLibraries() {
//        // Given
//        Library mockLibrary = new Library();
//        when(libraryRepository.findByAddress(OHRID)).thenReturn(List.of(mockLibrary));
//
//        // When
//        List<Library> libraries = defaultLibraryService.findByAddress(OHRID);
//
//        // Then
//        verify(libraryRepository, times(1)).findByAddress(OHRID);
//        verify(libraryRepository, times(1)).save(mockLibrary);  // Ensure save is called
//    }
    
    @Test
    void getMembers_ShouldReturnListOfMembers() {
        Member member1 = new Member();
        Member member2 = new Member();

        when(memberRepository.findByLibraryId(1)).thenReturn(Arrays.asList(member1, member2));

        List<Member> result = libraryService.getMembers(1);

        assertEquals(2, result.size());
        verify(memberRepository, times(1)).findByLibraryId(1);
    }
}
