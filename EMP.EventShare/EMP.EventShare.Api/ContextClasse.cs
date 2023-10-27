using EMP.EventShare.Api.Entite;
using Microsoft.EntityFrameworkCore;

namespace EMP.EventShare.Api
{
    public class ContextClasse : DbContext
    {

        public ContextClasse(DbContextOptions<ContextClasse> options) : base(options) {

        }
        public DbSet<Event> Evenements { get; set; }


    }
}
