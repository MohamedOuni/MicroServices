using EMP.EventShare.Api.Entite;

namespace EMP.EventShare.Api.Services
{
    public class EventService
    {


        private readonly ContextClasse dbContext;

        public EventService(ContextClasse dbContext)
        {
            this.dbContext = dbContext;
        }

        public IEnumerable<Event> GetEvenements()
        {
            return dbContext.Evenements.ToList();
        }

        public Event GetEvenementById(int id)
        {
            return dbContext.Evenements.FirstOrDefault(e => e.Id == id);
        }

        public void CreateEvenement(Event evenement)
        {
            dbContext.Evenements.Add(evenement);
            dbContext.SaveChanges();
        }

        public void UpdateEvenement(int id, Event updatedEvenement)
        {
            var existingEvenement = dbContext.Evenements.FirstOrDefault(e => e.Id == id);
            if (existingEvenement != null)
            {
                existingEvenement.Titre = updatedEvenement.Titre;
                dbContext.SaveChanges();
            }
        }

        public void DeleteEvenement(int id)
        {
            var evenement = dbContext.Evenements.FirstOrDefault(e => e.Id == id);
            if (evenement != null)
            {
                dbContext.Evenements.Remove(evenement);
                dbContext.SaveChanges();
            }
        }
    }
}

