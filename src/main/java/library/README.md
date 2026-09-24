
OBS! Läs beskrivningar till commits för en klarare bild av händelseförloppet!!

Struktur:
    Record: Book
    Class: FrontDesk, Library, Loan, Member

Varför record?
    Book är den enda klassen som aldrig får ändras. En människa kan aldrig bestämma att en bok
    ska ha en ny titel eller författare utan att ge ut en ny utgåva.
    Ett system som inte tillåter ändringar av en Member hade kunnat fungera men är inte realistiskt.
    En person kan byta för- eller efternamn och då behöver registret uppdateras.

Vem gör vad och varför?
    Book, Member och Loan fungerar som hjälpmedel för att berätta för Library hur de ska skapas
     och behandlas.

    Library drar i alla trådar. Den håller koll på vilka böcker, medlemmar och lån vi har,
    och vad alla dessa har för egenskaper, villkor och tillstånd.

    FrontDesk är vår biblotekarie. Den har befogenheter att berätta för library vad som ska
    göras, men det är upp till Library att godkänna FrontDesks förfrågningar. Därför har
    jag delat in metoderna i verkställande metoder, med undermetoder (Library) och förfrågningar med
    kontroller (FrontDesk). Exempel: Om man söker på "August Strindberg123" ska FrontDesk
    stoppa  så tidigt som möjligt. Librarys metoder ska aldrig köras i onödan.

Min tankeprocess:
    Jag skapade först strukturen helt utan hinder. Därefter har den här uppgiften varit
    en oändlig resa av trial and error (SE COMMITS).

    Jag har försökt gå balansgång mellan att låta Gemini hjälpa mig och att själv
    brute-forca uppgiften med det jag själv lärt mig.
    Efter många prompts av "hjälp mig med det här men ge mig inte svaret"
    fick jag en idé som visade sig vara väldigt effektiv:

    När jag istället för att fråga frågor, självsäkert argumenterade för något som jag visste var fel
    på samma sätt som AI-agenter brukar göra fick jag plötsligt mänskligare och *mycket* bättre respons.
    Mer riktade förklaringar och färre lata "här är en kod du kan kopiera till ditt projekt".

Begränsningar:
    Hade jag fått använda t.ex. en ArrayList hade det varit mindre kod att skriva
    och mindre att tänka på. Utöver det har jag ingenting att tillägga här.

    

